package r06.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.actions.NewWizardShortcutAction;
import org.eclipse.ui.wizards.IWizardDescriptor;

@SuppressWarnings("restriction")
public class AddPlanAction implements IObjectActionDelegate {

	private Shell shell;
	
	/**
	 * Constructor for Action1.
	 */
	public AddPlanAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		
		IWizardDescriptor wizardDesc = WorkbenchPlugin.getDefault()
				.getNewWizardRegistry().findWizard("r06.addPlanWizards.AddPlanWizard"); 
		if (wizardDesc != null) {
			NewWizardShortcutAction shortcutAction = new NewWizardShortcutAction(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
					wizardDesc);
			shortcutAction.run();
		}
		/*MessageDialog.openInformation(
				shell,
				"RiskDesigner",
				"addPlan Action was executed.");*/
		
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
