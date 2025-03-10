package at.kalwodaknezevic.inventoryhub.presentation.www;

public interface ControllerSupport {

    final static String ADD_PATH = "/add";
    final static String KEY_PATH_VAR = "/{key}";
    final static String EDIT_PATH = KEY_PATH_VAR + "/edit";
    final static String DELETE_PATH = KEY_PATH_VAR + "/delete";

    String INDEX_TEMPLATE = "index";
    String DETAIL_TEMPLATE = "detail";
    String ADD_FORM_TEMPLATE = "addForm";
    String EDIT_FORM_TEMPLATE = "editForm";

    String getTemplateBaseDir();

    default String redirect(String route) {
        return "redirect:%s".formatted(route);
    }

    default String forward(String route) {
        return "forward:%s".formatted(route);
    }

    default String template(String name) {
        return getTemplateBaseDir() + name;
    }
}