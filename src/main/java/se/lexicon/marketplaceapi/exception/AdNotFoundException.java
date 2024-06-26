package se.lexicon.marketplaceapi.exception;

import java.text.MessageFormat;

public class AdNotFoundException extends RuntimeException {

    public AdNotFoundException(final Long id) {
        super(MessageFormat.format("Ad {0} not found", id));
    }
}
