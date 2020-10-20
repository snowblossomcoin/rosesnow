package org.snowblossom.rosesnow;

import io.swagger.model.*;
import snowblossom.lib.ChainHash;
import snowblossom.lib.TransactionUtil;

import snowblossom.proto.TransactionInner;
import snowblossom.proto.TransactionInput;
import snowblossom.proto.TransactionOutput;

public class RoseUtil
{

  public static Transaction protoToModel( snowblossom.proto.Transaction s_tx)
  {
    Transaction tx = new Transaction();
    tx.setTransactionIdentifier( new TransactionIdentifier().hash( new ChainHash(s_tx.getTxHash()).toString() ));

    TransactionInner inner = TransactionUtil.getInner(s_tx);

    long tx_idx = 0;
    for(TransactionInput tx_in : inner.getInputsList())
    {
      Operation o = new Operation();
      o.setOperationIdentifier( new OperationIdentifier().index(tx_idx) );
      o.setType("SPEND");
      o.setStatus("OK");



      tx.getOperations().add(o);
      tx_idx++;
    }
    for(TransactionOutput tx_out : inner.getOutputsList())
    {
      Operation o = new Operation();
      o.setOperationIdentifier( new OperationIdentifier().index(tx_idx) );
      o.setType("RECEIVE");
      o.setStatus("OK");


      tx.getOperations().add(o);
      tx_idx++;
    }



    return tx;
  }

}
