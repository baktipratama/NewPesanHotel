package com.studio.bakti.newpesanhotel.task;

import android.content.Context;

/**
 * Created by heriman on 3/11/15.
 */
interface ITask<T> {

    /**
     * Run this task immediately.
     */
    T process() throws Exception;

    Context getContext();
}
