B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=12.2
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	
	

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private txtprice2 As EditText
	Private chkham, chkhaw, chkpep As CheckBox
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("laypizza")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Private Sub chkpep_CheckedChange(Checked As Boolean)
	If chkpep.Checked = True Then
		txtprice2.Text = txtprice2.Text + 400
	Else
		txtprice2.Text = txtprice2.Text - 400
	End If
	
End Sub

Private Sub chkhaw_CheckedChange(Checked As Boolean)
	If chkhaw.Checked = True Then
		txtprice2.Text = txtprice2.Text + 300
	Else
		txtprice2.Text = txtprice2.Text - 300
	End If
	
End Sub

Private Sub chkham_CheckedChange(Checked As Boolean)
	If chkham.Checked = True Then
		txtprice2.Text = txtprice2.Text + 200
	Else
		txtprice2.Text = txtprice2.Text - 200
	End If
	
End Sub

Private Sub btnhome2_Click
	Activity.Finish
	
End Sub

Private Sub btnclear2_Click
	chkham.Checked=False
	chkhaw.Checked=False
	chkpep.Checked=False
	txtprice2.Text ="0"
End Sub

Private Sub btnaccept2_Click
	Main.priceforpizza = txtprice2.Text
	Msgbox("Transaction Confirmed","Successful")
	Activity.Finish
End Sub