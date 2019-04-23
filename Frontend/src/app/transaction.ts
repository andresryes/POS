import { Customer } from '../customer';
import { User } from '../user';
import { TransactionDetails } from '../transactionDetails';

export class Transaction {
  idTransaction:int;
  customer:Customer;
  user:User;
  transactions:TransactionDetails[];
  total:double;
}
