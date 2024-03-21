package se.lexicon.marketplaceapi.exception;

import java.text.MessageFormat;

public class AdExistsException extends RuntimeException{

    public AdExistsException(final Long adId, final Long userId) {
        super(MessageFormat.format("Ad {0} is posted by User {1}", adId, userId));
    }
}
