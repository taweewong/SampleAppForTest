package com.nextzy.sampleappfortest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_login.*

class LoginAlertDialog : DialogFragment() {
    companion object {
        private const val EXTRA_MESSAGE = "com.nextzy.sampleappfortest.extra_message"

        fun newInstance(message: String): LoginAlertDialog {
            val instance = LoginAlertDialog()
            val bundle = Bundle()
            bundle.putString(EXTRA_MESSAGE, message)
            instance.arguments = bundle
            return instance
        }
    }

    private var message = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        message = arguments?.getString(EXTRA_MESSAGE) ?: ""
        return inflater.inflate(R.layout.dialog_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewDialogMessage.text = message
        buttonDialogOk.setOnClickListener {
            dismiss()
        }
    }
}