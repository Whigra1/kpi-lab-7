package entities;

public class Producer {
    private String image;
    private String new_image;
    private String producer_name;
    private String types;
    private String steps;
    private String region_id;
    private String description;

    public String getImage() {
        return image;
    }

    public Producer setImage(String image) {
        this.image = image;
        return this;
    }

    public String getNew_image() {
        return new_image;
    }

    public Producer setNew_image(String new_image) {
        this.new_image = new_image;
        return this;
    }

    public String getProducer_name() {
        return producer_name;
    }

    public Producer setProducer_name(String producer_name) {
        this.producer_name = producer_name;
        return this;
    }

    public String getTypes() {
        return types;
    }

    public Producer setTypes(String types) {
        this.types = types;
        return this;
    }

    public String getSteps() {
        return steps;
    }

    public Producer setSteps(String steps) {
        this.steps = steps;
        return this;
    }

    public String getRegion_id() {
        return region_id;
    }

    public Producer setRegion_id(String region_id) {
        this.region_id = region_id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Producer setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "image='" + image + '\'' +
                ", new_image='" + new_image + '\'' +
                ", producer_name='" + producer_name + '\'' +
                ", types='" + types + '\'' +
                ", steps='" + steps + '\'' +
                ", region_id='" + region_id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
