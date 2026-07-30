package anonymousex.interfaceex.ui;

import nestedInterface.Button.OnClickListener;

public class Button {
	OnClickListener listener;
	public void setListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();
	}
	
	// 중첩인터페이스
	interface OnClickListener {
		void onClick();
	}
}
