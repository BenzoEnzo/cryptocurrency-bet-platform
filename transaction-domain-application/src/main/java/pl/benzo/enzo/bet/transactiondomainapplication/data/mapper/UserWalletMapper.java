package pl.benzo.enzo.bet.transactiondomainapplication.data.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.benzo.enzo.bet.platformlibrary.base.BaseMapper;
import pl.benzo.enzo.bet.platformlibrary.model.transaction.UserWalletDTO;
import pl.benzo.enzo.bet.transactiondomainapplication.data.UserWallet;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserWalletMapper implements BaseMapper<UserWallet, UserWalletDTO> {
    private final UserTransactionMapper userTransactionMapper;

    @Override
    public UserWallet mapToEntity(UserWalletDTO dto) {
        UserWallet entity = new UserWallet();
        entity.setId(dto.getId());
        entity.setUserId(dto.getUserId());
        entity.setMoneros(dto.getMoneros());
        entity.setWalletAddress(dto.getWalletAddress());
        return entity;
    }

    @Override
    public UserWalletDTO mapToDto(UserWallet userWallet) {
        UserWalletDTO dto = new UserWalletDTO();
        dto.setId(userWallet.getId());
        dto.setUserId(userWallet.getUserId());
        dto.setMoneros(userWallet.getMoneros());
        dto.setWalletAddress(userWallet.getWalletAddress());
        if (userWallet.getHistoryTransactions() != null) {
            dto.setHistoryTransactions(userWallet.getHistoryTransactions().stream()
                    .map(userTransactionMapper::mapToDto)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    @Override
    public void mapToUpdate(UserWalletDTO userWalletDTO) {

    }
}
