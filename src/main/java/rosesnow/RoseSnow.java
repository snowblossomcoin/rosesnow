package org.snowblossom.rosesnow;

import io.swagger.model.NetworkIdentifier;

import snowblossom.node.SnowBlossomNode;

import org.junit.Assert;
import java.util.HashMap;
import duckutil.ConfigMem;
import java.util.TreeMap;
import snowblossom.lib.Globals;

/**
 * The idea here is we have a bunch of static methods that can be called
 * from the API controller classes.  Everything should be thread safe.
 */
public class RoseSnow
{

  private static HashMap<NetworkIdentifier, SnowBlossomNode> node_map = new HashMap<>();

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
  
      SnowBlossomNode node = new SnowBlossomNode(new ConfigMem(cm));

      node_map.put(id, node);

      return node;

    }

  }

  
  public static String getBaseDbPath()
  {
    // TODO - do something smart
    return "/home/nerd/db/rose";
  }

}

