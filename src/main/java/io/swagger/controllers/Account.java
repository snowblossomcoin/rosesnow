package io.swagger.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import io.swagger.model.*;
import io.swagger.model.AccountBalanceRequest;
import io.swagger.model.AccountBalanceResponse;
import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import java.util.LinkedList;
import java.util.List;
import org.snowblossom.rosesnow.RoseSnow;
import org.snowblossom.rosesnow.RoseUtil;
import snowblossom.client.GetUTXOUtil;
import snowblossom.client.StubHolder;
import snowblossom.lib.AddressSpecHash;
import snowblossom.lib.ChainHash;
import snowblossom.lib.NetworkParams;
import snowblossom.lib.TransactionBridge;
import snowblossom.node.SnowBlossomNode;
import snowblossom.proto.BlockHeader;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class Account 
{
  public ResponseContext accountCoins(RequestContext request , JsonNode body)
    throws Exception
  {
    AccountCoinsRequest req = new ObjectMapper().readValue(body.toString(), AccountCoinsRequest.class);
    NetworkIdentifier id = req.getNetworkIdentifier();
    AccountIdentifier acct = req.getAccountIdentifier();
    

    ChainHash block_hash = null;
    SnowBlossomNode node = RoseSnow.getNode(id);
    StubHolder stub_holder = RoseSnow.getClient(id);
    NetworkParams params = RoseUtil.getParams(id);

    if (block_hash == null)
    {
      BlockHeader head = node.getBlockIngestor().getHead().getHeader();
      block_hash = new ChainHash( head.getSnowHash());

    }
    BlockHeader header = node.getDB().getBlockSummaryMap().get(block_hash.getBytes()).getHeader();

    AddressSpecHash addr = new AddressSpecHash( acct.getAddress(), node.getParams());

    List<TransactionBridge> bridges;


    if ((req.isIncludeMempool() != null) && (req.isIncludeMempool().booleanValue()))
    {
      bridges = ImmutableList.copyOf(new GetUTXOUtil( stub_holder, params).getSpendableWithMempool(addr).values());

    }
    else
    {
      bridges = GetUTXOUtil.getSpendableValidatedStatic(
        addr, 
        stub_holder.getBlockingStub(), 
        header.getUtxoRootHash());
    }


   
    AccountCoinsResponse resp = new AccountCoinsResponse();
    LinkedList<Coin> coins = new LinkedList<>();
    for(TransactionBridge br : bridges)
    {
      if (!br.spent)
      {
        Coin c = new Coin();
        c.setAmount( RoseUtil.getSnowAmount( br.value, node.getParams() ));

        ChainHash tx_out = new ChainHash(br.in.getSrcTxId());
        int out_idx = br.in.getSrcTxOutIdx();

        c.setCoinIdentifier( new CoinIdentifier().identifier( tx_out.toString() + ":" + out_idx));

        coins.add(c);
      }

    }

    resp.setCoins(coins);

    // TODO - there is a race condition where if mempool check is set
    // the block could have changed between our first lookup and our second
    // so this might not be accurate
    resp.setBlockIdentifier( new BlockIdentifier().hash(block_hash.toString()).index( (long) header.getBlockHeight()));

    return new ResponseContext().entity(resp);
  }

   
  public ResponseContext accountBalance(RequestContext request , JsonNode body) 
    throws Exception
  {
    AccountBalanceRequest req = new ObjectMapper().readValue(body.toString(), AccountBalanceRequest.class);
    NetworkIdentifier id = req.getNetworkIdentifier();
    AccountIdentifier acct = req.getAccountIdentifier();

    PartialBlockIdentifier pbi = req.getBlockIdentifier();
    ChainHash block_hash = null;
    int block_idx;
    SnowBlossomNode node = RoseSnow.getNode(id);

    if (pbi != null)
    {
      if (pbi.getHash() != null) block_hash = new ChainHash(pbi.getHash());
      else
      {
        block_hash = node.getDB().getBlockHashAtHeight(pbi.getIndex().intValue());
      }
    }


    StubHolder stub_holder = RoseSnow.getClient(id);

    if (block_hash == null)
    {
      BlockHeader head = node.getBlockIngestor().getHead().getHeader();
      block_hash = new ChainHash( head.getSnowHash());

    }
    BlockHeader header = node.getDB().getBlockSummaryMap().get(block_hash.getBytes()).getHeader();

    AddressSpecHash addr = new AddressSpecHash( acct.getAddress(), node.getParams());


    List<TransactionBridge> bridges = GetUTXOUtil.getSpendableValidatedStatic(
      addr, 
      stub_holder.getBlockingStub(), 
      header.getUtxoRootHash());

   
    AccountBalanceResponse resp = new AccountBalanceResponse();
    long total = 0;
    LinkedList<Coin> coins = new LinkedList<>();
    for(TransactionBridge br : bridges)
    {
      total += br.value;
      Coin c = new Coin();
      c.setAmount( RoseUtil.getSnowAmount( br.value, node.getParams() ));

      ChainHash tx_out = new ChainHash(br.in.getSrcTxId());
      int out_idx = br.in.getSrcTxOutIdx();

      c.setCoinIdentifier( new CoinIdentifier().identifier( tx_out.toString() + ":" + out_idx));

      coins.add(c);

    }
    //resp.setCoins(coins);
    resp.getBalances().add( RoseUtil.getSnowAmount( total, node.getParams() ) );
    resp.setBlockIdentifier( new BlockIdentifier().hash(block_hash.toString()).index( (long) header.getBlockHeight()));

    return new ResponseContext().entity(resp);
  }

}
