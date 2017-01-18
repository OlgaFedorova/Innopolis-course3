package ru.innopolis.uni.course3.patterns.state;

/**
 * Created by Olga on 18.01.2017.
 */
public class Document {

    private String name;
    private String description;
    private int type;
    private String sign;
    private String comment;
    private DocumentStateEnum state;

    public void load() throws Exception {
        if (state == null){
            state = DocumentStateEnum.NEW;
        }else{
            throw new Exception();
        }
    }

    public void sign(String sign) throws Exception {
        switch (state){
            case NEW:
                this.setSign(sign);
                state = DocumentStateEnum.SIGNED_SENDED;
                break;
            default:
                throw new Exception();
        }
    }

    public void approve() throws Exception {
        switch (state){
            case SIGNED_SENDED:
                state = DocumentStateEnum.APPROVED;
                break;
            default:
                throw new Exception();
        }
    }

    public void reject() throws Exception {
        switch (state){
            case SIGNED_SENDED:
                state = DocumentStateEnum.REJECTED;
                break;
            default:
                throw new Exception();
        }

    }

    public void updateMain(String name, int type, String description) throws Exception {
        switch (state){
            case NEW:
                this.setName(name);
                this.setType(type);
                this.setDescription(description);
                break;
            default:
                throw new Exception();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
