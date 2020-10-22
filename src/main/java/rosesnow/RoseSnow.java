package org.snowblossom.rosesnow;

import io.swagger.model.NetworkIdentifier;

import snowblossom.node.SnowBlossomNode;

import org.junit.Assert;
import java.util.HashMap;
import duckutil.ConfigMem;
import java.util.TreeMap;
import snowblossom.lib.Globals;
import snowblossom.lib.LogSetup;
import snowblossom.client.StubHolder;
import snowblossom.client.StubUtil;
import snowblossom.lib.NetworkParams;

import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.io.File;


/**
 * The idea here is we have a bunch of static methods that can be called
 * from the API controller classes.  Everything should be thread safe.
 */
public class RoseSnow
{

  public static final String VERSION="0.1";


  private static HashMap<NetworkIdentifier, SnowBlossomNode> node_map = new HashMap<>();
  private static HashMap<NetworkIdentifier, StubHolder> client_map = new HashMap<>();


  /**
   * @param id Identifier of network
   */
  public static SnowBlossomNode getNode(NetworkIdentifier id)
    throws Exception
  {
    return getNode(id, true);
  }

  /**
   * @param id Identifier of network
   * @param start Start network if not started
   */
  public static SnowBlossomNode getNode(NetworkIdentifier id, boolean start)
    throws Exception
  {
    Assert.assertNotNull(id);
    Assert.assertEquals("snowblossom", id.getBlockchain());

    synchronized(node_map)
    {
      if (node_map.containsKey(id)) return node_map.get(id);

      if (!start) return null;

      String network = id.getNetwork();

      Globals.addCryptoProvider();

      TreeMap<String, String> cm = new TreeMap<>();
      cm.put("network", id.getNetwork());

      cm.put("db_type", "rocksdb");
      cm.put("tx_index", "true");
      cm.put("addr_index", "true");
      cm.put("db_path", getBaseDbPath() +"/" + network);

      new File(getBaseDbPath() +"/" + network).mkdirs();


      ConfigMem config = new ConfigMem(cm);

      NetworkParams params = NetworkParams.loadFromConfig(config);
      int port = params.getDefaultPort()*3;

      cm.put("service_port", ""+port);

      config = new ConfigMem(cm);

      LogSetup.setup(config);
      LogSetup.fixLevels();
  
      SnowBlossomNode node = new SnowBlossomNode(new ConfigMem(cm));

      node_map.put(id, node);

      StubHolder stub_holder = new StubHolder( StubUtil.openChannel("grpc://localhost:" + port, params));
      client_map.put(id, stub_holder);

      return node;

    }

  }

  public static StubHolder getClient(NetworkIdentifier id)
    throws Exception
  {
    getNode(id, true);
    synchronized(node_map)
    {
      return client_map.get(id);
    }

  }

  
  public static String getBaseDbPath()
  {
    // matching rosetta api expectations
    return "/data/snowblossom/db";
  }

}

