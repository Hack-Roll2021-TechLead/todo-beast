package seedu.address.model.tag;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Tag in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTagName(String)}
 */
public class Context {

    public static final String MESSAGE_CONSTRAINTS = "Tags names should be alphanumeric";
    public static final String VALIDATION_REGEX = "\\p{Alnum}+";

    public final String contextName;

    /**
     * Constructs a {@code Tag}.
     *
     * @param contextName A valid tag name.
     */
    public Context(String contextName) {
        requireNonNull(contextName);
        checkArgument(isValidContextName(contextName), MESSAGE_CONSTRAINTS);
        this.contextName = contextName;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidContextName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Context // instanceof handles nulls
                && contextName.equals(((Context) other).contextName)); // state check
    }

    @Override
    public int hashCode() {
        return contextName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + contextName + ']';
    }

}
