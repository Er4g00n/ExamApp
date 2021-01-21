package optaplanner;

import abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.optaplanner.core.api.domain.constraintweight.ConstraintConfiguration;
import org.optaplanner.core.api.domain.constraintweight.ConstraintWeight;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

/**
 * Institutional weightings.
 * Allows the user to recalibrate score weights.
 * <p>
 * Each {@link Calendrier} has only 1 instance of this class.
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

    // Hard constraints
    @ConstraintWeight("conflitExamenDansLaMemePeriode")
    public HardSoftScore getConflitExamenDansLaMemePeriodeAsScore() {
        return HardSoftScore.ofHard(conflitExamenDansLaMemePeriode);
    }

    @ConstraintWeight("periodeDureeTropCourte")
    public HardSoftScore getPeriodeDureeTropCourteAsScore() {
        return HardSoftScore.ofHard(periodeDureeTropCourte);
    }

    @ConstraintWeight("capaciteSalleTropPetite")
    public HardSoftScore getCapaciteSalleTropPetiteAsScore() {
        return HardSoftScore.ofHard(capaciteSalleTropPetite);
    }

    @ConstraintWeight("periodePenaliteExamenCoincidencePenalite")
    public HardSoftScore getPeriodePenaliteExamenCoincidencePenaliteAsScore() {
        return HardSoftScore.ofHard(periodePenaliteExamenCoincidencePenalite);
    }

    @ConstraintWeight("periodePenaliteExclusionPenalite")
    public HardSoftScore getPeriodePenaliteExclusionPenaliteAsScore() {
        return HardSoftScore.ofHard(periodePenaliteExclusionPenalite);
    }

    @ConstraintWeight("periodePenaliteAfterPenalite")
    public HardSoftScore getPeriodePenaliteAfterPenaliteAsScore() {
        return HardSoftScore.ofHard(periodePenaliteAfterPenalite);
    }

    @ConstraintWeight("sallePenaliteExclusivePenalite")
    public HardSoftScore getSallePenaliteExclusivePenaliteAsScore() {
        return HardSoftScore.ofHard(sallePenaliteExclusivePenalite);
    }

    // Soft constraints
    @ConstraintWeight("twoExamensInARow")
    public HardSoftScore getTwoInARowPenaliteAsScore() {
        return HardSoftScore.ofSoft(twoInARowPenalite);
    }

    @ConstraintWeight("twoExamensInAJour")
    public HardSoftScore getTwoInAJourPenaliteAsScore() {
        return HardSoftScore.ofSoft(twoInAJourPenalite);
    }

    @ConstraintWeight("periodeSpread")
    public HardSoftScore getPeriodeSpreadPenaliteAsScore() {
        return HardSoftScore.ofSoft(periodeSpreadPenalite);
    }

    @ConstraintWeight("mixedDurees")
    public HardSoftScore getMixedDureePenaliteAsScore() {
        return HardSoftScore.ofSoft(mixedDureePenalite);
    }

    @ConstraintWeight("frontLoad")
    public HardSoftScore getFrontLoadPenaliteAsScore() {
        return HardSoftScore.ofSoft(frontLoadPenalite);
    }

    @ConstraintWeight("periodePenalite")
    public HardSoftScore getPeriodePenalitePenaliteAsScore() {
        return HardSoftScore.ofSoft(periodePenalitePenalite);
    }

    @ConstraintWeight("sallePenalite")
    public HardSoftScore getSallePenalitePenaliteAsScore() {
        return HardSoftScore.ofSoft(sallePenalitePenalite);
    }

    // ************************************************************************
    // Getters and setters
    // ************************************************************************

    // Hard constraint functions
    public int getConflitExamenDansLaMemePeriode() {
        return conflitExamenDansLaMemePeriode;
    }

    public void setConflitExamenDansLaMemePeriode(int conflitExamenDansLaMemePeriode) {
        this.conflitExamenDansLaMemePeriode = conflitExamenDansLaMemePeriode;
    }

    public int getPeriodeDureeTropCourte() {
        return periodeDureeTropCourte;
    }

    public void setPeriodeDureeTropCourte(int periodeDureeTropCourte) {
        this.periodeDureeTropCourte = periodeDureeTropCourte;
    }

    public int getCapaciteSalleTropPetite() {
        return capaciteSalleTropPetite;
    }

    public void setCapaciteSalleTropPetite(int capaciteSalleTropPetite) {
        this.capaciteSalleTropPetite = capaciteSalleTropPetite;
    }

    public int getPeriodePenaliteExamenCoincidencePenalite() {
        return periodePenaliteExamenCoincidencePenalite;
    }

    public void setPeriodePenaliteExamenCoincidencePenalite(int periodePenaliteExamenCoincidencePenalite) {
        this.periodePenaliteExamenCoincidencePenalite = periodePenaliteExamenCoincidencePenalite;
    }

    public int getPeriodePenaliteExclusionPenalite() {
        return periodePenaliteExclusionPenalite;
    }

    public void setPeriodePenaliteExclusionPenalite(int periodePenaliteExclusionPenalite) {
        this.periodePenaliteExclusionPenalite = periodePenaliteExclusionPenalite;
    }

    public int getPeriodePenaliteAfterPenalite() {
        return periodePenaliteAfterPenalite;
    }

    public void setPeriodePenaliteAfterPenalite(int periodePenaliteAfterPenalite) {
        this.periodePenaliteAfterPenalite = periodePenaliteAfterPenalite;
    }

    public int getSallePenaliteExclusivePenalite() {
        return sallePenaliteExclusivePenalite;
    }

    public void setSallePenaliteExclusivePenalite(int sallePenaliteExclusivePenalite) {
        this.sallePenaliteExclusivePenalite = sallePenaliteExclusivePenalite;
    }

    // Soft constraint functions
    public int getTwoInARowPenalite() {
        return twoInARowPenalite;
    }

    public void setTwoInARowPenalite(int twoInARowPenalite) {
        this.twoInARowPenalite = twoInARowPenalite;
    }

    public int getTwoInAJourPenalite() {
        return twoInAJourPenalite;
    }

    public void setTwoInAJourPenalite(int twoInAJourPenalite) {
        this.twoInAJourPenalite = twoInAJourPenalite;
    }

    public int getPeriodeSpreadLength() {
        return periodeSpreadLength;
    }

    public void setPeriodeSpreadLength(int periodeSpreadLength) {
        this.periodeSpreadLength = periodeSpreadLength;
    }

    public int getPeriodeSpreadPenalite() {
        return periodeSpreadPenalite;
    }

    public void setPeriodeSpreadPenalite(int periodeSpreadPenalite) {
        this.periodeSpreadPenalite = periodeSpreadPenalite;
    }

    public int getMixedDureePenalite() {
        return mixedDureePenalite;
    }

    public void setMixedDureePenalite(int mixedDureePenalite) {
        this.mixedDureePenalite = mixedDureePenalite;
    }

    public int getFrontLoadLargeEpreuveSize() {
        return frontLoadLargeEpreuveSize;
    }

    public void setFrontLoadLargeEpreuveSize(int frontLoadLargeEpreuveSize) {
        this.frontLoadLargeEpreuveSize = frontLoadLargeEpreuveSize;
    }

    public int getFrontLoadLastPeriodeSize() {
        return frontLoadLastPeriodeSize;
    }

    public void setFrontLoadLastPeriodeSize(int frontLoadLastPeriodeSize) {
        this.frontLoadLastPeriodeSize = frontLoadLastPeriodeSize;
    }

    public int getFrontLoadPenalite() {
        return frontLoadPenalite;
    }

    public void setFrontLoadPenalite(int frontLoadPenalite) {
        this.frontLoadPenalite = frontLoadPenalite;
    }

    public int getPeriodePenalitePenalite() {
        return periodePenalitePenalite;
    }

    public void setPeriodePenalitePenalite(int periodePenalitePenalite) {
        this.periodePenalitePenalite = periodePenalitePenalite;
    }

    public int getSallePenalitePenalite() {
        return sallePenalitePenalite;
    }

    public void setSallePenalitePenalite(int sallePenalitePenalite) {
        this.sallePenalitePenalite = sallePenalitePenalite;
    }

    // ************************************************************************
    // With methods
    // ************************************************************************

    public CalendrierContraintes withConflitExamenDansLaMemePeriode(int conflitExamenDansLaMemePeriode) {
        this.setConflitExamenDansLaMemePeriode(conflitExamenDansLaMemePeriode);
        return this;
    }

    public CalendrierContraintes withPeriodeDureeTropCourte(int periodeDureeTropCourte) {
        this.setPeriodeDureeTropCourte(periodeDureeTropCourte);
        return this;
    }

    public CalendrierContraintes withCapaciteSalleTropPetite(int capaciteSalleTropPetite) {
        this.setCapaciteSalleTropPetite(capaciteSalleTropPetite);
        return this;
    }

    public CalendrierContraintes withPeriodePenaliteExamenCoincidencePenalite(int periodePenaliteExamenCoincidencePenalite) {
        this.setPeriodePenaliteExamenCoincidencePenalite(periodePenaliteExamenCoincidencePenalite);
        return this;
    }

    public CalendrierContraintes withPeriodePenaliteExclusionPenalite(int periodePenaliteExclusionPenalite) {
        this.setPeriodePenaliteExclusionPenalite(periodePenaliteExclusionPenalite);
        return this;
    }

    public CalendrierContraintes withPeriodePenaliteAfterPenalite(int periodePenaliteAfterPenalite) {
        this.setPeriodePenaliteAfterPenalite(periodePenaliteAfterPenalite);
        return this;
    }

    public CalendrierContraintes withSallePenaliteExclusivePenalite(int sallePenaliteExclusivePenalite) {
        this.setSallePenaliteExclusivePenalite(sallePenaliteExclusivePenalite);
        return this;
    }

    public CalendrierContraintes withTwoInARowPenalite(int twoInARowPenalite) {
        this.setTwoInARowPenalite(twoInARowPenalite);
        return this;
    }

    public CalendrierContraintes withTwoInAJourPenalite(int twoInAJourPenalite) {
        this.setTwoInAJourPenalite(twoInAJourPenalite);
        return this;
    }

    public CalendrierContraintes withPeriodeSpreadLength(int periodeSpreadLength) {
        this.setPeriodeSpreadLength(periodeSpreadLength);
        return this;
    }

    public CalendrierContraintes withPeriodeSpreadPenalite(int periodeSpreadPenalite) {
        this.setPeriodeSpreadPenalite(periodeSpreadPenalite);
        return this;
    }

    public CalendrierContraintes withMixedDureePenalite(int mixedDureePenalite) {
        this.setMixedDureePenalite(mixedDureePenalite);
        return this;
    }

    public CalendrierContraintes withFrontLoadLargeEpreuveSize(int frontLoadLargeEpreuveSize) {
        this.setFrontLoadLargeEpreuveSize(frontLoadLargeEpreuveSize);
        return this;
    }

    public CalendrierContraintes withFrontLoadLastPeriodeSize(int frontLoadLastPeriodeSize) {
        this.setFrontLoadLastPeriodeSize(frontLoadLastPeriodeSize);
        return this;
    }

    public CalendrierContraintes withFrontLoadPenalite(int frontLoadPenalite) {
        this.setFrontLoadPenalite(frontLoadPenalite);
        return this;
    }

    public CalendrierContraintes withPeriodePenalitePenalite(int periodePenalitePenalite) {
        this.setPeriodePenalitePenalite(periodePenalitePenalite);
        return this;
    }

    public CalendrierContraintes withSallePenalitePenalite(int sallePenalitePenalite) {
        this.setSallePenalitePenalite(sallePenalitePenalite);
        return this;
    }
}
