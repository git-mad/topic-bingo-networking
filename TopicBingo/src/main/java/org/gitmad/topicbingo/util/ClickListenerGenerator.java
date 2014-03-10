package org.gitmad.topicbingo.util;

import android.view.View;

/**
 * Created by thedekel on 3/9/14.
 */
public interface ClickListenerGenerator {

    public View.OnClickListener generateClickListner(final Integer position);
}
