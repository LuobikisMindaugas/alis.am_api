package lt.codeacademy.alis.api;


/**
 * @Author Mindaugas Luobikis
 */
public interface Endpoint {
    String UUID = "uuid";
    String NR = "nr";

    String API_ROOT = "/alis/api";

    String LICENSES = "/licenses";
    String LICENSE = "/{" + UUID + "}";
    String LICENSE_NR = "/{" + NR + "}";
    String DELETE_LICENSE = "/{" + UUID + "}/delete";


    String AREAS = "/areas";
    String AREA = "/{" + UUID + "}";

}
