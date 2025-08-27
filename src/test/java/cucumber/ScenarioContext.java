package cucumber;

import constants.Context;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

  private final Map<String, Object> scenarioContext = new HashMap<>();
  private Map<Class<?>, Object> genericContext = new HashMap<>();

  public <T> T putGenericContext(Class<T> klass, T obj) {
    return klass.cast(genericContext.put(klass, obj));
  }

  public <T> T getGenericContext(Class<T> klass) {
    return klass.cast(genericContext.get(klass));
  }

  public void setContext(Context key, Object value) {
    scenarioContext.put(key.toString(), value);
  }

  public Object getContext(Context key) {
    return scenarioContext.get(key.toString());
  }

  public void setContext(String key, Object value) {
    scenarioContext.put(key, value);
  }

  public Object getContext(String key) {
    return scenarioContext.get(key);
  }

  public int getContextAsInt(Context key) {
    return (int) scenarioContext.get(key.toString());
  }

  public String getContextAsString(Context key) {
    return (String) scenarioContext.get(key.toString());
  }
}
