package ql.questionaire;


import java.util.List;

import org.eclipse.swt.widgets.Composite;

import ql.ast.node.syntactic.Form;
import ql.ast.visitor.AllQuestionsCollecter;
import ql.questionaire.controller.QuestionaireController;
import ql.questionaire.model.QuestionaireModel;
import ql.questionaire.model.question.QuestionModel;
import ql.questionaire.view.QuestionView;
import ql.questionaire.view.QuestionaireView;

public class Questionaire {

	public static void run(Form tree) { 
		List<QuestionModel> questionModelList = createQuestionList(tree);

		QuestionaireView view = new QuestionaireView();
		QuestionaireModel model = new QuestionaireModel(questionModelList,tree);		
		QuestionaireController controller = new QuestionaireController(view,model);			
		view.setController(controller);

		createQuestionViews(questionModelList, view, controller);	
		view.start();	
	}

	private static void createQuestionViews(
			List<QuestionModel> questionModelList, QuestionaireView view,
			QuestionaireController controller) {
		Composite parent = view.getDisplayParent();
		for(QuestionModel q : questionModelList) {
			new QuestionView(q, controller, parent);
		}
	}

	private static List<QuestionModel> createQuestionList(Form tree) {
		return new AllQuestionsCollecter().collect(tree);
	}

}
