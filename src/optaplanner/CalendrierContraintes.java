package optaplanner;

import abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.optaplanner.core.api.domain.constraintweight.ConstraintConfiguration;
import org.optaplanner.core.api.domain.constraintweight.ConstraintWeight;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

/**
 * Permet de set les contraintes
 * Permet à l'utilisateur de recalibrer les poids des scores.
 * <p>
 * Each {@link Calendrier} n'a qu'une seule instance de cette classe.
 */
@ConstraintConfiguration(constraintPackage = "optaplanner.solver")
@XStreamAlias("CalendrierContraintes")
public class CalendrierContraintes extends AbstractPersistable {
    // Hard constraints
    private int conflitExamenDansLaMemePeriode = 1;
    private int periodeDureeTropCourte = 1;
    private int capaciteSalleTropPetite = 1;
    private int periodePenaliteExamenCoincidencePenalite = 1;
    private int periodePenaliteExclusionPenalite = 1;
    private int periodePenaliteAfterPenalite = 1;
    private int sallePenaliteExclusivePenalite = 1;

    // Soft constraints
    private int twoInARowPenalite;
    private int twoInAJourPenalite;
    private int periodeSpreadLength;
    private int periodeSpreadPenalite;
    private int mixedDureePenalite;
    private int frontLoadLargeEpreuveSize;
    private int frontLoadLastPeriodeSize;
    private int frontLoadPenalite;
    private int periodePenalitePenalite = 1;
    private int sallePenalitePenalite = 1;

    // ************************************************************************
    // Constraint weight methods
    // ************************************************************************

    /**
     * Gets conflit examen dans la meme periode as score.
     *
     * @return the conflit examen dans la meme periode as score
     */
// Hard constraints
    @ConstraintWeight("conflitExamenDansLaMemePeriode")
    public HardSoftScore getConflitExamenDansLaMemePeriodeAsScore() {
        return HardSoftScore.ofHard(conflitExamenDansLaMemePeriode);
    }

    /**
     * Gets periode duree trop courte as score.
     *
     * @return the periode duree trop courte as score
     */
    @ConstraintWeight("periodeDureeTropCourte")
    public HardSoftScore getPeriodeDureeTropCourteAsScore() {
        return HardSoftScore.ofHard(periodeDureeTropCourte);
    }

    /**
     * Gets capacite salle trop petite as score.
     *
     * @return the capacite salle trop petite as score
     */
    @ConstraintWeight("capaciteSalleTropPetite")
    public HardSoftScore getCapaciteSalleTropPetiteAsScore() {
        return HardSoftScore.ofHard(capaciteSalleTropPetite);
    }

    /**
     * Gets periode penalite examen coincidence penalite as score.
     *
     * @return the periode penalite examen coincidence penalite as score
     */
    @ConstraintWeight("periodePenaliteExamenCoincidencePenalite")
    public HardSoftScore getPeriodePenaliteExamenCoincidencePenaliteAsScore() {
        return HardSoftScore.ofHard(periodePenaliteExamenCoincidencePenalite);
    }

    /**
     * Gets periode penalite exclusion penalite as score.
     *
     * @return the periode penalite exclusion penalite as score
     */
    @ConstraintWeight("periodePenaliteExclusionPenalite")
    public HardSoftScore getPeriodePenaliteExclusionPenaliteAsScore() {
        return HardSoftScore.ofHard(periodePenaliteExclusionPenalite);
    }

    /**
     * Gets periode penalite after penalite as score.
     *
     * @return the periode penalite after penalite as score
     */
    @ConstraintWeight("periodePenaliteAfterPenalite")
    public HardSoftScore getPeriodePenaliteAfterPenaliteAsScore() {
        return HardSoftScore.ofHard(periodePenaliteAfterPenalite);
    }

    /**
     * Gets salle penalite exclusive penalite as score.
     *
     * @return the salle penalite exclusive penalite as score
     */
    @ConstraintWeight("sallePenaliteExclusivePenalite")
    public HardSoftScore getSallePenaliteExclusivePenaliteAsScore() {
        return HardSoftScore.ofHard(sallePenaliteExclusivePenalite);
    }

    /**
     * Gets two in a row penalite as score.
     *
     * @return the two in a row penalite as score
     */
// Soft constraints
    @ConstraintWeight("twoExamensInARow")
    public HardSoftScore getTwoInARowPenaliteAsScore() {
        return HardSoftScore.ofSoft(twoInARowPenalite);
    }

    /**
     * Gets two in a jour penalite as score.
     *
     * @return the two in a jour penalite as score
     */
    @ConstraintWeight("twoExamensInAJour")
    public HardSoftScore getTwoInAJourPenaliteAsScore() {
        return HardSoftScore.ofSoft(twoInAJourPenalite);
    }

    /**
     * Gets periode spread penalite as score.
     *
     * @return the periode spread penalite as score
     */
    @ConstraintWeight("periodeSpread")
    public HardSoftScore getPeriodeSpreadPenaliteAsScore() {
        return HardSoftScore.ofSoft(periodeSpreadPenalite);
    }

    /**
     * Gets mixed duree penalite as score.
     *
     * @return the mixed duree penalite as score
     */
    @ConstraintWeight("mixedDurees")
    public HardSoftScore getMixedDureePenaliteAsScore() {
        return HardSoftScore.ofSoft(mixedDureePenalite);
    }

    /**
     * Gets front load penalite as score.
     *
     * @return the front load penalite as score
     */
    @ConstraintWeight("frontLoad")
    public HardSoftScore getFrontLoadPenaliteAsScore() {
        return HardSoftScore.ofSoft(frontLoadPenalite);
    }

    /**
     * Gets periode penalite penalite as score.
     *
     * @return the periode penalite penalite as score
     */
    @ConstraintWeight("periodePenalite")
    public HardSoftScore getPeriodePenalitePenaliteAsScore() {
        return HardSoftScore.ofSoft(periodePenalitePenalite);
    }

    /**
     * Gets salle penalite penalite as score.
     *
     * @return the salle penalite penalite as score
     */
    @ConstraintWeight("sallePenalite")
    public HardSoftScore getSallePenalitePenaliteAsScore() {
        return HardSoftScore.ofSoft(sallePenalitePenalite);
    }

    // ************************************************************************
    // Getters and setters
    // ************************************************************************

    /**
     * Gets conflit examen dans la meme periode.
     *
     * @return the conflit examen dans la meme periode
     */
// Hard constraint functions
    public int getConflitExamenDansLaMemePeriode() {
        return conflitExamenDansLaMemePeriode;
    }

    /**
     * Sets conflit examen dans la meme periode.
     *
     * @param conflitExamenDansLaMemePeriode the conflit examen dans la meme periode
     */
    public void setConflitExamenDansLaMemePeriode(int conflitExamenDansLaMemePeriode) {
        this.conflitExamenDansLaMemePeriode = conflitExamenDansLaMemePeriode;
    }

    /**
     * Gets periode duree trop courte.
     *
     * @return the periode duree trop courte
     */
    public int getPeriodeDureeTropCourte() {
        return periodeDureeTropCourte;
    }

    /**
     * Sets periode duree trop courte.
     *
     * @param periodeDureeTropCourte the periode duree trop courte
     */
    public void setPeriodeDureeTropCourte(int periodeDureeTropCourte) {
        this.periodeDureeTropCourte = periodeDureeTropCourte;
    }

    /**
     * Gets capacite salle trop petite.
     *
     * @return the capacite salle trop petite
     */
    public int getCapaciteSalleTropPetite() {
        return capaciteSalleTropPetite;
    }

    /**
     * Sets capacite salle trop petite.
     *
     * @param capaciteSalleTropPetite the capacite salle trop petite
     */
    public void setCapaciteSalleTropPetite(int capaciteSalleTropPetite) {
        this.capaciteSalleTropPetite = capaciteSalleTropPetite;
    }

    /**
     * Gets periode penalite examen coincidence penalite.
     *
     * @return the periode penalite examen coincidence penalite
     */
    public int getPeriodePenaliteExamenCoincidencePenalite() {
        return periodePenaliteExamenCoincidencePenalite;
    }

    /**
     * Sets periode penalite examen coincidence penalite.
     *
     * @param periodePenaliteExamenCoincidencePenalite the periode penalite examen coincidence penalite
     */
    public void setPeriodePenaliteExamenCoincidencePenalite(int periodePenaliteExamenCoincidencePenalite) {
        this.periodePenaliteExamenCoincidencePenalite = periodePenaliteExamenCoincidencePenalite;
    }

    /**
     * Gets periode penalite exclusion penalite.
     *
     * @return the periode penalite exclusion penalite
     */
    public int getPeriodePenaliteExclusionPenalite() {
        return periodePenaliteExclusionPenalite;
    }

    /**
     * Sets periode penalite exclusion penalite.
     *
     * @param periodePenaliteExclusionPenalite the periode penalite exclusion penalite
     */
    public void setPeriodePenaliteExclusionPenalite(int periodePenaliteExclusionPenalite) {
        this.periodePenaliteExclusionPenalite = periodePenaliteExclusionPenalite;
    }

    /**
     * Gets periode penalite after penalite.
     *
     * @return the periode penalite after penalite
     */
    public int getPeriodePenaliteAfterPenalite() {
        return periodePenaliteAfterPenalite;
    }

    /**
     * Sets periode penalite after penalite.
     *
     * @param periodePenaliteAfterPenalite the periode penalite after penalite
     */
    public void setPeriodePenaliteAfterPenalite(int periodePenaliteAfterPenalite) {
        this.periodePenaliteAfterPenalite = periodePenaliteAfterPenalite;
    }

    /**
     * Gets salle penalite exclusive penalite.
     *
     * @return the salle penalite exclusive penalite
     */
    public int getSallePenaliteExclusivePenalite() {
        return sallePenaliteExclusivePenalite;
    }

    /**
     * Sets salle penalite exclusive penalite.
     *
     * @param sallePenaliteExclusivePenalite the salle penalite exclusive penalite
     */
    public void setSallePenaliteExclusivePenalite(int sallePenaliteExclusivePenalite) {
        this.sallePenaliteExclusivePenalite = sallePenaliteExclusivePenalite;
    }

    /**
     * Gets two in a row penalite.
     *
     * @return the two in a row penalite
     */
// Soft constraint functions
    public int getTwoInARowPenalite() {
        return twoInARowPenalite;
    }

    /**
     * Sets two in a row penalite.
     *
     * @param twoInARowPenalite the two in a row penalite
     */
    public void setTwoInARowPenalite(int twoInARowPenalite) {
        this.twoInARowPenalite = twoInARowPenalite;
    }

    /**
     * Gets two in a jour penalite.
     *
     * @return the two in a jour penalite
     */
    public int getTwoInAJourPenalite() {
        return twoInAJourPenalite;
    }

    /**
     * Sets two in a jour penalite.
     *
     * @param twoInAJourPenalite the two in a jour penalite
     */
    public void setTwoInAJourPenalite(int twoInAJourPenalite) {
        this.twoInAJourPenalite = twoInAJourPenalite;
    }

    /**
     * Gets periode spread length.
     *
     * @return the periode spread length
     */
    public int getPeriodeSpreadLength() {
        return periodeSpreadLength;
    }

    /**
     * Sets periode spread length.
     *
     * @param periodeSpreadLength the periode spread length
     */
    public void setPeriodeSpreadLength(int periodeSpreadLength) {
        this.periodeSpreadLength = periodeSpreadLength;
    }

    /**
     * Gets periode spread penalite.
     *
     * @return the periode spread penalite
     */
    public int getPeriodeSpreadPenalite() {
        return periodeSpreadPenalite;
    }

    /**
     * Sets periode spread penalite.
     *
     * @param periodeSpreadPenalite the periode spread penalite
     */
    public void setPeriodeSpreadPenalite(int periodeSpreadPenalite) {
        this.periodeSpreadPenalite = periodeSpreadPenalite;
    }

    /**
     * Gets mixed duree penalite.
     *
     * @return the mixed duree penalite
     */
    public int getMixedDureePenalite() {
        return mixedDureePenalite;
    }

    /**
     * Sets mixed duree penalite.
     *
     * @param mixedDureePenalite the mixed duree penalite
     */
    public void setMixedDureePenalite(int mixedDureePenalite) {
        this.mixedDureePenalite = mixedDureePenalite;
    }

    /**
     * Gets front load large epreuve size.
     *
     * @return the front load large epreuve size
     */
    public int getFrontLoadLargeEpreuveSize() {
        return frontLoadLargeEpreuveSize;
    }

    /**
     * Sets front load large epreuve size.
     *
     * @param frontLoadLargeEpreuveSize the front load large epreuve size
     */
    public void setFrontLoadLargeEpreuveSize(int frontLoadLargeEpreuveSize) {
        this.frontLoadLargeEpreuveSize = frontLoadLargeEpreuveSize;
    }

    /**
     * Gets front load last periode size.
     *
     * @return the front load last periode size
     */
    public int getFrontLoadLastPeriodeSize() {
        return frontLoadLastPeriodeSize;
    }

    /**
     * Sets front load last periode size.
     *
     * @param frontLoadLastPeriodeSize the front load last periode size
     */
    public void setFrontLoadLastPeriodeSize(int frontLoadLastPeriodeSize) {
        this.frontLoadLastPeriodeSize = frontLoadLastPeriodeSize;
    }

    /**
     * Gets front load penalite.
     *
     * @return the front load penalite
     */
    public int getFrontLoadPenalite() {
        return frontLoadPenalite;
    }

    /**
     * Sets front load penalite.
     *
     * @param frontLoadPenalite the front load penalite
     */
    public void setFrontLoadPenalite(int frontLoadPenalite) {
        this.frontLoadPenalite = frontLoadPenalite;
    }

    /**
     * Gets periode penalite penalite.
     *
     * @return the periode penalite penalite
     */
    public int getPeriodePenalitePenalite() {
        return periodePenalitePenalite;
    }

    /**
     * Sets periode penalite penalite.
     *
     * @param periodePenalitePenalite the periode penalite penalite
     */
    public void setPeriodePenalitePenalite(int periodePenalitePenalite) {
        this.periodePenalitePenalite = periodePenalitePenalite;
    }

    /**
     * Gets salle penalite penalite.
     *
     * @return the salle penalite penalite
     */
    public int getSallePenalitePenalite() {
        return sallePenalitePenalite;
    }

    /**
     * Sets salle penalite penalite.
     *
     * @param sallePenalitePenalite the salle penalite penalite
     */
    public void setSallePenalitePenalite(int sallePenalitePenalite) {
        this.sallePenalitePenalite = sallePenalitePenalite;
    }

    // ************************************************************************
    // With methods
    // ************************************************************************

    /**
     * With conflit examen dans la meme periode calendrier contraintes.
     *
     * @param conflitExamenDansLaMemePeriode the conflit examen dans la meme periode
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withConflitExamenDansLaMemePeriode(int conflitExamenDansLaMemePeriode) {
        this.setConflitExamenDansLaMemePeriode(conflitExamenDansLaMemePeriode);
        return this;
    }

    /**
     * With periode duree trop courte calendrier contraintes.
     *
     * @param periodeDureeTropCourte the periode duree trop courte
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withPeriodeDureeTropCourte(int periodeDureeTropCourte) {
        this.setPeriodeDureeTropCourte(periodeDureeTropCourte);
        return this;
    }

    /**
     * With capacite salle trop petite calendrier contraintes.
     *
     * @param capaciteSalleTropPetite the capacite salle trop petite
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withCapaciteSalleTropPetite(int capaciteSalleTropPetite) {
        this.setCapaciteSalleTropPetite(capaciteSalleTropPetite);
        return this;
    }

    /**
     * With periode penalite examen coincidence penalite calendrier contraintes.
     *
     * @param periodePenaliteExamenCoincidencePenalite the periode penalite examen coincidence penalite
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withPeriodePenaliteExamenCoincidencePenalite(int periodePenaliteExamenCoincidencePenalite) {
        this.setPeriodePenaliteExamenCoincidencePenalite(periodePenaliteExamenCoincidencePenalite);
        return this;
    }

    /**
     * With periode penalite exclusion penalite calendrier contraintes.
     *
     * @param periodePenaliteExclusionPenalite the periode penalite exclusion penalite
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withPeriodePenaliteExclusionPenalite(int periodePenaliteExclusionPenalite) {
        this.setPeriodePenaliteExclusionPenalite(periodePenaliteExclusionPenalite);
        return this;
    }

    /**
     * With periode penalite after penalite calendrier contraintes.
     *
     * @param periodePenaliteAfterPenalite the periode penalite after penalite
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withPeriodePenaliteAfterPenalite(int periodePenaliteAfterPenalite) {
        this.setPeriodePenaliteAfterPenalite(periodePenaliteAfterPenalite);
        return this;
    }

    /**
     * With salle penalite exclusive penalite calendrier contraintes.
     *
     * @param sallePenaliteExclusivePenalite the salle penalite exclusive penalite
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withSallePenaliteExclusivePenalite(int sallePenaliteExclusivePenalite) {
        this.setSallePenaliteExclusivePenalite(sallePenaliteExclusivePenalite);
        return this;
    }

    /**
     * With two in a row penalite calendrier contraintes.
     *
     * @param twoInARowPenalite the two in a row penalite
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withTwoInARowPenalite(int twoInARowPenalite) {
        this.setTwoInARowPenalite(twoInARowPenalite);
        return this;
    }

    /**
     * With two in a jour penalite calendrier contraintes.
     *
     * @param twoInAJourPenalite the two in a jour penalite
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withTwoInAJourPenalite(int twoInAJourPenalite) {
        this.setTwoInAJourPenalite(twoInAJourPenalite);
        return this;
    }

    /**
     * With periode spread length calendrier contraintes.
     *
     * @param periodeSpreadLength the periode spread length
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withPeriodeSpreadLength(int periodeSpreadLength) {
        this.setPeriodeSpreadLength(periodeSpreadLength);
        return this;
    }

    /**
     * With periode spread penalite calendrier contraintes.
     *
     * @param periodeSpreadPenalite the periode spread penalite
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withPeriodeSpreadPenalite(int periodeSpreadPenalite) {
        this.setPeriodeSpreadPenalite(periodeSpreadPenalite);
        return this;
    }

    /**
     * With mixed duree penalite calendrier contraintes.
     *
     * @param mixedDureePenalite the mixed duree penalite
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withMixedDureePenalite(int mixedDureePenalite) {
        this.setMixedDureePenalite(mixedDureePenalite);
        return this;
    }

    /**
     * With front load large epreuve size calendrier contraintes.
     *
     * @param frontLoadLargeEpreuveSize the front load large epreuve size
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withFrontLoadLargeEpreuveSize(int frontLoadLargeEpreuveSize) {
        this.setFrontLoadLargeEpreuveSize(frontLoadLargeEpreuveSize);
        return this;
    }

    /**
     * With front load last periode size calendrier contraintes.
     *
     * @param frontLoadLastPeriodeSize the front load last periode size
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withFrontLoadLastPeriodeSize(int frontLoadLastPeriodeSize) {
        this.setFrontLoadLastPeriodeSize(frontLoadLastPeriodeSize);
        return this;
    }

    /**
     * With front load penalite calendrier contraintes.
     *
     * @param frontLoadPenalite the front load penalite
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withFrontLoadPenalite(int frontLoadPenalite) {
        this.setFrontLoadPenalite(frontLoadPenalite);
        return this;
    }

    /**
     * With periode penalite penalite calendrier contraintes.
     *
     * @param periodePenalitePenalite the periode penalite penalite
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withPeriodePenalitePenalite(int periodePenalitePenalite) {
        this.setPeriodePenalitePenalite(periodePenalitePenalite);
        return this;
    }

    /**
     * With salle penalite penalite calendrier contraintes.
     *
     * @param sallePenalitePenalite the salle penalite penalite
     * @return the calendrier contraintes
     */
    public CalendrierContraintes withSallePenalitePenalite(int sallePenalitePenalite) {
        this.setSallePenalitePenalite(sallePenalitePenalite);
        return this;
    }
}
