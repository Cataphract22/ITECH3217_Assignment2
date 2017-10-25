//
// functions.js
//

// The back() method loads the previous URL in the history list.
// 
// This is the same as clicking the "Back button" in your browser, or history.go(-1).
// 
// Note: This method will not work if the previous page does not exist in the history list.
function goBackAPage() {
    window.history.back();
}