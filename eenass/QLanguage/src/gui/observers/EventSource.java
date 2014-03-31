package gui.observers;

public interface EventSource {
	void addListener(EventListener e);
	void removeListener(EventListener e);
}
