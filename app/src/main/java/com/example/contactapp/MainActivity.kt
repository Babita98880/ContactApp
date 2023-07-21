package com.example.contactapp
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "ContactApp"
    }
    fun addContact(view: View) {
        val etContactFirstName: EditText = findViewById(R.id.editTextFirstName)
        val etContactLastName: EditText = findViewById(R.id.editTextLastName)
        val etContactNumber: EditText = findViewById(R.id.editTextPhoneHome)
        val name: String = etContactFirstName.text.toString()+ etContactLastName.text.toString()
        val phone = etContactNumber.text.toString()
        val intent = Intent(ContactsContract.Intents.Insert.ACTION)
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE)
        intent.putExtra(ContactsContract.Intents.Insert.NAME, name)
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone)
        startActivityForResult(intent, 1)
    }
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        intent: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Added Contact", Toast.LENGTH_SHORT).show()
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled Added Contact", Toast.LENGTH_SHORT).show()
            }
        }
    }
}