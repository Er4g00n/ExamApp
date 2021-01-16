package optaplanner;

import abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Not used during score calculation, so not inserted into the working memory.
 */
@XStreamAlias("Etudiant")
public class Etudiant extends AbstractPersistable {
    public Etudiant() {
    }

    public Etudiant(long id) {
        super(id);
    }
}
