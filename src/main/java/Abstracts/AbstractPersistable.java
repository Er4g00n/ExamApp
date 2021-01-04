
package Abstracts;

import org.optaplanner.core.api.domain.lookup.PlanningId;

/**
 * Cette classe provient des classes communes des exemples d'optaplanner
 * Cette classe centralise le toString() dans le projet
 */
public abstract class AbstractPersistable {

    protected Long id;

    protected AbstractPersistable() {
    }

    protected AbstractPersistable(long id) {
        this.id = id;
    }

    /**
     * Renvoie l'id de l'element
     * Est utilisé par Optaplanner comme id
     * @return the id
     */
    @PlanningId
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getName().replaceAll(".*\\.", "") + "-" + id;
    }

}
