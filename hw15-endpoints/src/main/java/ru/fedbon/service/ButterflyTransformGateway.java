package ru.fedbon.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.fedbon.domain.Butterfly;
import ru.fedbon.domain.Caterpillar;

import java.util.Collection;

/**
 * Gateway.
 *
 * @author Irina Ilina
 */
@MessagingGateway
public interface ButterflyTransformGateway {

    @Gateway(requestChannel = "caterpillarChannel", replyChannel = "butterflyChannel")
    Collection<Butterfly> process(Collection<Caterpillar> caterpillars);
}
