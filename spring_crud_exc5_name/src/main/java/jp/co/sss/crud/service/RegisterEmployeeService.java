package jp.co.sss.crud.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.repository.EmployeeRepository;
import jp.co.sss.crud.util.BeanManager;
/**
 * 従業員登録サービスクラス。
 * フォームから入力された従業員情報をデータベースに新規登録します。
 * EmployeeFormからEmployeeエンティティへの変換処理も含まれます。
 * 
 * @author SystemShared Co., Ltd.
 * @version 1.0
 * @since 1.0
 */
@Service
public class RegisterEmployeeService {
	/**
	 * 従業員データアクセス用リポジトリ。
	 * Spring DIによって自動注入されます。
	 */
	//TODO ここに記述
		@Autowired
		private EmployeeRepository repository;
	/**
	 * 新規従業員を登録します。
	 * 
	 * EmployeeFormに格納された従業員情報をEmployeeエンティティに変換し、
	 * データベースに新規レコードとして保存します。
	 * 変換処理はBeanManager.copyFormToEntityメソッドを使用して行います。
	 * 
	 * @param employeeForm 登録する従業員情報を格納したフォームオブジェクト
	 */
	//TODO ここに記述
	public void execute(EmployeeForm employeeForm) {
		Employee newEmployee = BeanManager.copyFormToEntity(employeeForm);
		repository.save(newEmployee);
	}
}