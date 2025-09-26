package jp.co.sss.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.repository.EmployeeRepository;
import jp.co.sss.crud.util.BeanManager;

/**
 * 従業員名検索サービスクラス。
 * 指定された検索文字列を含む従業員名を持つ従業員情報を取得し、EmployeeBeanリストとして返却します。
 * 部分一致検索を行い、検索結果は従業員IDの昇順でソートされます。
 * 
 * @author SystemShared Co., Ltd.
 * @version 1.0
 * @since 1.0
 */
@Service
public class SearchForEmployeesByEmpNameService {

	/**
	 * 従業員データアクセス用リポジトリ。
	 * Spring DIによって自動注入されます。
	 */
	//TODO ここに記述
	@Autowired
	private EmployeeRepository repository;
	/**
	 * 従業員名による部分一致検索を実行します。
	 * 
	 * 指定された検索文字列を含む従業員名を持つ従業員を検索し、
	 * BeanManagerを使用してEmployeeBeanリストに変換して返却します。
	 * 検索は大文字小文字を区別し、部分一致で行われます。
	 * 
	 * @param searchString 検索対象の文字列（従業員名に含まれる文字列）
	 * @return 検索文字列を含む従業員名を持つEmployeeBeanリスト（従業員ID昇順）。
	 *         該当する従業員が存在しない場合は空のリストを返却
	 */
	//TODO ここに記述
	public List<EmployeeBean> execute(String searchString) {

		List<Employee> empList = repository.findByEmpNameContainingOrderByEmpId(searchString);
		List<EmployeeBean> returnEmployeeBeans = BeanManager.copyEntityListToBeanList(empList);

		return returnEmployeeBeans;
	}
}