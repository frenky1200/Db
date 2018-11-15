package com.example.vpb.db

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vpb.db.MyApp.Companion.db
import kotlinx.android.synthetic.main.fragment_second.view.*
import org.jetbrains.anko.db.insert

class DBFragment : androidx.fragment.app.Fragment() {

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_second, container, false)
        rootView.button2.setOnClickListener { onClick() }
        return rootView
    }

    private fun onClick() {

        db.writableDatabase
        db.use {
            insert("Customer",
                "name" to rootView.eName.text.toString(),
                "login" to rootView.eLogin.text.toString(),
                "pass" to rootView.ePass.text.toString())
        }
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): DBFragment {
            val fragment = DBFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}