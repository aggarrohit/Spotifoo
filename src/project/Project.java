package project;

public class Project {

    public Project() {
        ProjectModel model = new ProjectModel();
        ProjectView view = new ProjectView();
        ProjectController controller = new ProjectController(model, view);

        controller.catchMainMenuInput();
    }

}
