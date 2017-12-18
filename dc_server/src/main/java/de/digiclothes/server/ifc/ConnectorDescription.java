package de.digiclothes.server.ifc;

/**
 * Descriptor of a ConnectorDescription
 *
 * @author Christian Plewnia
 */
public class ConnectorDescription {

    private String id;
    private String locationDescription;

    public ConnectorDescription(String id, String locationDescription) {
        this.id = id;
        this.locationDescription = locationDescription;
    }

    public String getId() {
        return id;
    }

    public String getLocationDescription() {
        return locationDescription;
    }
}
