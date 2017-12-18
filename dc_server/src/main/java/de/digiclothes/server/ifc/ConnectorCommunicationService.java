package de.digiclothes.server.ifc;

import de.madana.common.datastructures.DC_ShoppingCart;
import de.madana.common.datastructures.ShoppingCart;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Communication of the Server with the Connectors
 *
 * @author Christian Plewnia
 */
public interface ConnectorCommunicationService {

    /**
     * Retrieves a list of all connectors that are currently connected to the server.
     *
     * @return List of connectors
     */
    List<ConnectorDescription> getActiveConnectors();

    DC_ShoppingCart getShoppingCart(String strConnectorId) throws ClassNotFoundException, IOException, Exception;
    /**
     * Asks the connector identified by the given id for its currently available shopping cart.
     *
     * @param connectorId The connector's unique identifier
     * @return Promise to return a shopping cart or Optional.empty(), if no shopping cart is available
     * @deprecated -> Use getShoppingCart Instead
     */
    @Deprecated 
    CompletableFuture<Optional<ShoppingCart>> askForShoppingCart(String connectorId);

    /**
     * Informs a connector about a successful payment of its shopping cart.
     * <p>
     * Note that the connector tells - when asked to - the server about the current active shopping cart (that are all
     * items within an input zone). The server then takes care of processing the payment and informs the connector in
     * case the payment was successful.
     * <p>
     * Note that it is the responsibility of the server (i.e. the client of this library), to keep the association
     * between the connector and the shopping cart correct. That means, that one should not inform one connector about
     * the successful payment of another connector's shopping cart.
     *
     * @param connectorId  ID of the responsible connector
     * @param shoppingCart The shopping cart (makes sure, that server and connector are on the same page with respect
     *                     to what has been payed)
     * @return Promise to return in case the connector successfully received the notification
     */
    CompletableFuture<Void> notifyConnectorAboutSuccessfulPayment(String connectorId, ShoppingCart shoppingCart);

}
