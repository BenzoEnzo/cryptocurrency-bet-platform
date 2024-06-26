package pl.benzo.enzo.bet.transactiondomainapplication.data.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.benzo.enzo.bet.platformlibrary.base.BaseMapper;
import pl.benzo.enzo.bet.platformlibrary.model.TransactionDTO;
import pl.benzo.enzo.bet.platformlibrary.model.transaction.UserTransactionDTO;
import pl.benzo.enzo.bet.transactiondomainapplication.data.UserTransaction;

@Component
public class UserTransactionMapper implements BaseMapper<UserTransaction, UserTransactionDTO> {

    @Override
    public UserTransaction mapToEntity(UserTransactionDTO dto) {
        UserTransaction entity = new UserTransaction();
        entity.setUserId(dto.getUserId());
        entity.setMoneros(dto.getMoneros());
        entity.setWalletAddress(dto.getWalletAddress());
        entity.setTransactionStatus(dto.getTransactionStatus());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setBetId(dto.getBetId());
        entity.setDeprecate(dto.isDeprecate());
        return entity;
    }

    @Override
    public UserTransactionDTO mapToDto(UserTransaction userTransaction) {
        UserTransactionDTO dto = new UserTransactionDTO();
        dto.setId(userTransaction.getId());
        dto.setUserId(userTransaction.getUserId());
        dto.setMoneros(userTransaction.getMoneros());
        dto.setWalletAddress(userTransaction.getWalletAddress());
        dto.setTransactionStatus(userTransaction.getTransactionStatus());
        dto.setCreatedAt(userTransaction.getCreatedAt());
        dto.setBetId(userTransaction.getBetId());
        dto.setDeprecate(userTransaction.isDeprecate());
        return dto;
    }

    @Override
    public void mapToUpdate(UserTransactionDTO userTransactionDTO) {

    }
}
