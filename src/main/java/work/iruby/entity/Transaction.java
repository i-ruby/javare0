package work.iruby.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Ruby
 * @date 2020/12/16 0:17
 */
@Data
@AllArgsConstructor
public class Transaction {
    private Trader trader;
    private int year;
    private int value;
}
