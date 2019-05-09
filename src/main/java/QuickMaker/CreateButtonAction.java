package QuickMaker;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.editor.BasicModelEditor;
import com.change_vision.jude.api.inf.editor.ClassDiagramEditor;
import com.change_vision.jude.api.inf.editor.IDiagramEditorFactory;
import com.change_vision.jude.api.inf.editor.IModelEditorFactory;
import com.change_vision.jude.api.inf.editor.ITransactionManager;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.project.ProjectAccessor;

public class CreateButtonAction implements ActionListener {
	private JTextArea textArea;

	public void setText(JTextArea text) {
		textArea = text;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {

			AstahAPI api = AstahAPI.getAstahAPI();
			ProjectAccessor projectAccessor = api.getProjectAccessor();
			projectAccessor.getProject();
			IModelEditorFactory modelEditorFactory = projectAccessor.getModelEditorFactory();
			BasicModelEditor basicModelEditor = modelEditorFactory.getBasicModelEditor();
			IDiagramEditorFactory diagramEditorFactory = projectAccessor.getDiagramEditorFactory();
			ClassDiagramEditor classDiagramEditor = diagramEditorFactory.getClassDiagramEditor();
			ITransactionManager transactionManager = projectAccessor.getTransactionManager();

			int x = 10;
			for (String className : textArea.getText().split("\r\n|\r|\n")) {
				transactionManager.beginTransaction();
				IClass newClass = basicModelEditor.createClass(projectAccessor.getProject(), className);
				transactionManager.endTransaction();

				//transactionManager.beginTransaction();
				//classDiagramEditor.createNodePresentation(newClass, new Point(0,x));
				//transactionManager.endTransaction();

				x+=30;
			}
		} catch (Exception e) {

		}

	}

}
