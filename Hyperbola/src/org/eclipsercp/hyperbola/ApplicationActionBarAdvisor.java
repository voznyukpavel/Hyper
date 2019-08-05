package org.eclipsercp.hyperbola;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.StatusLineContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
    private IWorkbenchAction exitAction;
    private IWorkbenchAction aboutAction;
    private AddContactAction addContactAction;
    private StatusLineContributionItem statusItem;
    private ChatAction chatAction;
    private Image statusImage;

    // private IWorkbenchAction test;

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    @Override
    protected void makeActions(IWorkbenchWindow window) {
        exitAction = ActionFactory.QUIT.create(window);
        register(exitAction);
        aboutAction = ActionFactory.ABOUT.create(window);
        register(aboutAction);
        addContactAction = new AddContactAction(window);
        register(addContactAction);
        chatAction = new ChatAction(window);
        register(chatAction);
      }


    @Override
    protected void fillMenuBar(IMenuManager menuBar) {
        MenuManager hyperbolaMenu = new MenuManager("&Hyperbola", "hyperbola");
        hyperbolaMenu.add(addContactAction);
        hyperbolaMenu.add(chatAction);
        hyperbolaMenu.add(new Separator());
        hyperbolaMenu.add(exitAction);
        MenuManager helpMenu = new MenuManager("&Help", "help");
        helpMenu.add(aboutAction);
        menuBar.add(hyperbolaMenu);
        menuBar.add(helpMenu);

    }

    @Override
    protected void fillCoolBar(ICoolBarManager coolBar) {
        IToolBarManager toolbar = new ToolBarManager(coolBar.getStyle());
        coolBar.add(toolbar);
        toolbar.add(addContactAction);
        toolbar.add(chatAction);
     //   toolbar.add(new Separator());
     //   toolbar.add(addContactAction);
    }

    @Override
    protected void fillStatusLine(IStatusLineManager statusLine) {
      statusItem = new StatusLineContributionItem("LoggedInStatus"); //$NON-NLS-1$
      statusItem.setText("Logged in"); //$NON-NLS-1$
      statusLine.add(statusItem);
    }
  

    protected void fillTrayItem(IMenuManager trayItem) {
        trayItem.add(aboutAction);
        trayItem.add(exitAction);
    }

}
