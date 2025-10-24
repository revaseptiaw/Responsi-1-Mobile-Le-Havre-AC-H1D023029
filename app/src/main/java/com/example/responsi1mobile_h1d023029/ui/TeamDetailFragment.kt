package com.example.responsi1mobile_h1d023029.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.responsi1mobile_h1d023029.databinding.FragmentTeamDetailBinding
import com.example.responsi1mobile_h1d023029.model.Player
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TeamDetailFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentTeamDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeamDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val player = arguments?.getParcelable<Player>("player")

        player?.let {
            binding.tvPlayerName.text = it.name ?: "-"
            binding.tvPlayerBirthdate.text = "Tanggal Lahir: ${it.dateOfBirth ?: "-"}"
            binding.tvPlayerNationality.text = "Kebangsaan: ${it.nationality ?: "-"}"
            binding.tvPlayerPosition.text = "Posisi: ${it.position ?: "-"}"
        }
    }

    companion object {
        fun newInstance(player: Player): TeamDetailFragment {
            val fragment = TeamDetailFragment()
            val args = Bundle()
            args.putParcelable("player", player)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
