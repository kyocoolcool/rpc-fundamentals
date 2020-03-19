package kyocoolcool;

import java.io.Serializable;

/**
 * @ClassName RpcRequest
 * @Description
 * @Author chris
 * @Date 2019/12/2 3:05 PM
 * @Version 1.0
 **/

public class RpcRequest implements Serializable{
    private static final long serialVersionUID = -6320394520880125927L;
    private String className;
    private String methodName;
    private Object[] parameters;

    public RpcRequest() {
    }

    public RpcRequest(String className, String methodName, Object[] parameters) {
        this.className = className;
        this.methodName = methodName;
        this.parameters = parameters;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
