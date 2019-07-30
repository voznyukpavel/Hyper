package org.eclipsercp.hyperbola.model;



/**
 * Encapsulates the state for a session, including the connection details (user
 * name, password, server) and the connection itself.
 */
public class Session {
    private ContactsGroup rootGroup;

    private String name;

    private String server;

    public Session() {
    }

    public void setSessionDescription(String name, String server) {
      this.name = name;
      this.server = server;
    }

    public ContactsGroup getRoot() {
      if (rootGroup == null)
        rootGroup = new ContactsGroup(null, "RootGroup");
      return rootGroup;
    }

    public String getName() {
      return name;
    }

    public String getServer() {
      return server;
    }
  }