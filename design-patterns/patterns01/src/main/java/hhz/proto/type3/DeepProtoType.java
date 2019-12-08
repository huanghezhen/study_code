package hhz.proto.type3;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

@Data
@NoArgsConstructor
public class DeepProtoType implements Serializable,Cloneable {
    private static final long serialVersionUID = 585402501830723337L;
    private String name;
    private DeepCloneableTarget deepCloneableTarget;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepProtoType clone = (DeepProtoType) super.clone();
        clone.setDeepCloneableTarget((DeepCloneableTarget) clone.deepCloneableTarget.clone());
        return super.clone();
    }


    public Object deepClone() {
        Object object = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;

        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;


        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            object = ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (oos != null) {
                    oos.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return object;
    }
}
