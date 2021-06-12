package lt.codeacademy.alis.api;


/**
 * @Author Mindaugas Luobikis
 */
public interface Endpoint {
    String UUID = "uuid";

    String API_ROOT = "/alis/api";

    String LICENSES = "/licenses";
    String LICENSE = "/{" + UUID + "}";

    String AREAS = "/areas";
    String AREA = "/{" + UUID + "}";

    String USERS = "/users";
}
