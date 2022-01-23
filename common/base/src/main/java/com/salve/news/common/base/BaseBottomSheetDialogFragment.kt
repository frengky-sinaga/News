package com.salve.news.common.base

abstract class BaseBottomSheetDialogFragment  {
    /*override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        dialog.behavior.apply {
            state = BottomSheetBehavior.STATE_EXPANDED
            addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    val state = listOf(
                        BottomSheetBehavior.STATE_COLLAPSED,
                        BottomSheetBehavior.STATE_HALF_EXPANDED
                    )
                    if (newState in state) this@apply.state = BottomSheetBehavior.STATE_EXPANDED
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            })
        }
        return dialog
    }

    abstract fun clearObjectsReference()

    override fun onDestroyView() {
        super.onDestroyView()
        clearObjectsReference()
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        clearObjectsReference()
    }*/
}