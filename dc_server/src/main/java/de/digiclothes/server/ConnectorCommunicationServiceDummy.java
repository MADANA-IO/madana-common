package de.digiclothes.server;

import de.digiclothes.server.ifc.ConnectorCommunicationService;
import de.digiclothes.server.ifc.ConnectorDescription;
import de.madana.common.datastructures.DC_ShoppingCart;
import de.madana.common.datastructures.ShoppingCart;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Dummy for tests
 */
public class ConnectorCommunicationServiceDummy implements ConnectorCommunicationService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<ConnectorDescription> getActiveConnectors() {
        return Arrays.asList(
                new ConnectorDescription("1", "H&N, Aachen Innenstadt"),
                new ConnectorDescription("2", "tOliver, Aachen Innenstadt"),
                new ConnectorDescription("3", "TimTailor, Aachen Innenstadt")
        );
    }

    @Override
    public CompletableFuture<Optional<ShoppingCart>> askForShoppingCart(String connectorId) {
        // This dummy code is a mess; TODO revise
        log.debug("Asking for shopping cart of connector " + connectorId);
        if (connectorId.equals("1")) {
            return CompletableFuture.completedFuture(
                    Optional.of(
                            new ShoppingCart(CurrencyUnit.EUR)
                                    .addItem(new ShoppingCart.Item("T-Shirt", Money.parse("EUR 9.99")))
                                    .addItem(new ShoppingCart.Item("Hose", Money.parse("EUR 49.99")))
                    )
            );
        } else if (connectorId.equals("2") || connectorId.equals("3")) {
            return CompletableFuture.completedFuture(
                    Optional.empty()
            );
        } else {
            log.error("Invalid connector id");
            // I am not sure whether this way of rejecting a promise can be considered a good idea... TODO revise
            CompletableFuture promise = new CompletableFuture<Optional<ShoppingCart>>();
            promise.completeExceptionally(new RuntimeException("Invalid connector Id"));
            return promise;
        }
    }

    @Override
    public CompletableFuture<Void> notifyConnectorAboutSuccessfulPayment(String connectorId, ShoppingCart
            shoppingCart) {
        return null;
    }

	@Override
	public DC_ShoppingCart getShoppingCart(String strConnectorId) {
		// TODO Auto-generated method stub
		return null;
	}
}
