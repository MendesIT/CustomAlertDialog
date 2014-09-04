package com.mendesit.android.customalertdialog;

import com.mendesit.customalertdialog.R;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAlertDialog extends Builder {

    private View mDialogView;
    private View mDivider;
    private TextView mTitle;
    private TextView mMessage;
    private ImageView mIcon;

    public CustomAlertDialog(Context context) {
        super(context);

        mDialogView = View.inflate(context, R.layout.custom_alert_dialog, null);
        setView(mDialogView);

        mTitle = (TextView) mDialogView.findViewById(R.id.dialog_title_alert_title);
        mMessage = (TextView) mDialogView.findViewById(R.id.text_view_message);
        mIcon = (ImageView) mDialogView.findViewById(R.id.image_view_icon);
        mDivider = mDialogView.findViewById(R.id.view_title_divider);
    }

    @Override
    public CustomAlertDialog setMessage(int message) {
        mMessage.setText(message);
        return this;
    }

    @Override
    public CustomAlertDialog setIcon(int icon) {
        mIcon.setImageResource(icon);
        return this;
    }

    @Override
    public AlertDialog show() {
        if (mTitle.getText().equals("")) {
            mDialogView.findViewById(R.id.linear_layout_top_panel).setVisibility(View.GONE);
        }
        return super.show();
    }

    @Override
    public CustomAlertDialog setTitle(CharSequence title) {
        mTitle.setText(title);
        return this;
    }

    @Override
    public CustomAlertDialog setTitle(int title) {
        mTitle.setText(title);
        return this;
    }

    @Override
    public CustomAlertDialog setMessage(CharSequence message) {
        mMessage.setText(message);
        return this;
    }

    @Override
    public CustomAlertDialog setIcon(Drawable icon) {
        mIcon.setImageDrawable(icon);
        return this;
    }

    public CustomAlertDialog setDividerColor(String colorString) {
        mDivider.setBackgroundColor(Color.parseColor(colorString));
        return this;
    }

    public CustomAlertDialog setTitleColor(String colorString) {
        mTitle.setTextColor(Color.parseColor(colorString));
        return this;
    }

    public CustomAlertDialog setCustomView(int resId, Context context) {
        View customView = View.inflate(context, resId, null);
        ((FrameLayout) mDialogView.findViewById(R.id.frame_layout_custom_panel)).addView(customView);
        return this;
    }
}
