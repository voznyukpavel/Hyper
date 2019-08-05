package org.eclipsercp.hyperbola;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

    @Override
    public void createInitialLayout(IPageLayout layout) {
      //  layout.setEditorAreaVisible(false);
        layout.setEditorAreaVisible(true);
        layout.addStandaloneView(ContactsView.ID, false, IPageLayout.LEFT, .50f, layout.getEditorArea());
    }
}
