package hhz.proto.type3;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class DeepCloneableTarget implements Serializable,Cloneable {
    private static final long serialVersionUID = 7044994710542179627L;
    private String name;
    private String age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
