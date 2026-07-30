package nestedInterface;

public class Button {
    public interface OnClickListener {
        void onClick();
    }

    OnClickListener listener; 

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }
    
    public void touch() {
        if (listener != null) {
            listener.onClick();
        }
    }
}