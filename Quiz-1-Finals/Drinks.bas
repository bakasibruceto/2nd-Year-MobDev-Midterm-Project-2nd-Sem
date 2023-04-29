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

	
	Private txtprice1 As EditText
	Private chkcoffee As CheckBox
	Private chksoda As CheckBox
	Private chktea As CheckBox
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("laydrinks")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Private Sub btnhome1_Click
	Activity.Finish
End Sub

Private Sub btnclear1_Click
	chkcoffee.Checked = False
	chktea.Checked = False
	chksoda.Checked = False
	txtprice1.Text = 0

End Sub

Private Sub btnaccept1_Click
	Main.pricefordrinks = txtprice1.Text
	Msgbox("Transaction Confirmed","Successful")
	Activity.Finish
End Sub

Private Sub chktea_CheckedChange(Checked As Boolean)
	If chktea.Checked = True Then
		txtprice1.Text = txtprice1.Text + 40
	Else
		txtprice1.Text = txtprice1.Text - 40
	End If
	
End Sub

Private Sub chksoda_CheckedChange(Checked As Boolean)
	If chksoda.Checked = True Then
		txtprice1.Text = txtprice1.Text + 30
	Else
		txtprice1.Text = txtprice1.Text - 30
	End If
	
End Sub

Private Sub chkcoffee_CheckedChange(Checked As Boolean)
	If chkcoffee.Checked = True Then
		txtprice1.Text = txtprice1.Text + 50
	Else
		txtprice1.Text = txtprice1.Text - 50
	End If
End Sub