package org.simpleaas.inspectiondocumentssteelproducts.data.productdata;

import java.util.Optional;

public class SemiFinishedProductSpecification {
    private Tube tube = null;
    private RectangularTube rectangularTube = null;
    private RoundBar roundBar = null;
    private HexagonalBar hexagonalBar = null;
    private RectangularBar rectangularBar = null;
    private SheetMetal sheetMetal = null;
    private Profile profile = null;

    public SemiFinishedProductSpecification setTube(Tube tube) {
        this.tube = tube;
        return this;
    }

    public Optional<Tube> getTube() {
        return Optional.ofNullable(this.tube);
    }

    public SemiFinishedProductSpecification setRectangularTube(RectangularTube rectangularTube) {
        this.rectangularTube = rectangularTube;
        return this;
    }

    public Optional<RectangularTube> getRectangularTube() {
        return Optional.ofNullable(this.rectangularTube);
    }

    public SemiFinishedProductSpecification setRoundBar(RoundBar roundBar) {
        this.roundBar = roundBar;
        return this;
    }

    public Optional<RoundBar> getRoundBar() {
        return Optional.ofNullable(this.roundBar);
    }

    public SemiFinishedProductSpecification setHexagonalBar(HexagonalBar hexagonalBar) {
        this.hexagonalBar = hexagonalBar;
        return this;
    }

    public Optional<HexagonalBar> getHexagonalBar() {
        return Optional.ofNullable(this.hexagonalBar);
    }

    public SemiFinishedProductSpecification setRectangularBar(RectangularBar rectangularBar) {
        this.rectangularBar = rectangularBar;
        return this;
    }

    public Optional<RectangularBar> getRectangularBar() {
        return Optional.ofNullable(this.rectangularBar);
    }

    public SemiFinishedProductSpecification setSheetMetal(SheetMetal sheetMetal) {
        this.sheetMetal = sheetMetal;
        return this;
    }

    public Optional<SheetMetal> getSheetMetal() {
        return Optional.ofNullable(this.sheetMetal);
    }

    public SemiFinishedProductSpecification setProfile(Profile profile) {
        this.profile = profile;
        return this;
    }

    public Optional<Profile> getProfile() {
        return Optional.ofNullable(this.profile);
    }
}
