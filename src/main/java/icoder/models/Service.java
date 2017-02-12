package icoder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Service model
 *
 * @since 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Service {
    private String name;
    private String version;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
