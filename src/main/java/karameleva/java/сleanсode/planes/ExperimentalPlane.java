package karameleva.java.сleanсode.planes;

import karameleva.java.сleanсode.models.ClassificationLevel;
import karameleva.java.сleanсode.models.ExperimentalTypes;

public class ExperimentalPlane extends Plane{
    private ExperimentalTypes typeOfExperimentalPlane;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes typeOfExperimentalPlane, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.typeOfExperimentalPlane = typeOfExperimentalPlane;
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalTypes getTypeOfExperimentalPlane() {
        return typeOfExperimentalPlane;
    }

    public void setTypeOfExperimentalPlane(ExperimentalTypes typeOfExperimentalPlane) {
        this.typeOfExperimentalPlane = typeOfExperimentalPlane;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}
